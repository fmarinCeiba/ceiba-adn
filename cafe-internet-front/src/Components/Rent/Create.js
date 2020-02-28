import React from 'react';
import axios from 'axios';
import { Button, TextField, InputAdornment, MenuItem } from '@material-ui/core';
import { Dialog, DialogActions, DialogContent, DialogTitle } from '@material-ui/core';
import { IconButton, Tooltip } from '@material-ui/core';
import AddIcon from '@material-ui/icons/AddCircle';

const convertDateToDateTimeLocal = date => {
  return `${date.getFullYear()}-${`${date.getMonth() + 1}`.padStart(2, 0)}-${`${date.getDate()}`.padStart(2, 0)}T${`${date.getHours()}`.padStart(2, 0)}:${`${date.getMinutes()}`.padStart(2, 0)}`
}

export default function FormDialog(props) {
  const { api, clients, computers, categories } = props;
  const [open, setOpen] = React.useState(false);
  const [start, setStart] = React.useState(convertDateToDateTimeLocal(new Date()));
  const [end, setEnd] = React.useState(convertDateToDateTimeLocal(new Date()));
  const [time, setTime] = React.useState(0);
  const [amount, setAmount] = React.useState(0);
  const [values, setValues] = React.useState({
    clientId: '',
    computerId: '',
    active: 1,
    start: '',
    end: ''
  });

  async function saveItem(url) {
    console.log(values)
    const response = await axios.put(url, values);
    console.log(response);
  }

  async function calculate(url, opc) {
    const response = await axios.get(url);
    const data = Number(response.data);
    if (opc === 'time') { setAmount(data); }
    if (opc === 'amount') { setTime(data); refreshStartAndEnd(data, values.computerId); }
  }

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSubmit = () => {
    handleClose();
    saveItem(api);
    window.location.reload(false);
  };

  const handleChange = prop => event => {
    console.log(prop);
    setValues({ ...values, [prop]: event.target.value });
    if (prop === 'computerId')
      if (event.target.value !== '') {
        const computer = computers.filter((c) => c.id === event.target.value)[0];
        const category = categories.filter((c) => c.id === computer.categoryId)[0];
        setTime(category.time);
        setAmount(category.amount);
        refreshStartAndEnd(category.time, event.target.value);
      } else {
        setTime(0);
        setAmount(0);
      }
  };

  const handleCalculate = prop => event => {
    console.log(prop, event.target.value);
    if (prop === 'time') {
      setTime(event.target.value);
      calculate(api + 'amount/' + values.computerId + '/' + event.target.value, 'time');
      refreshStartAndEnd(Number(event.target.value), values.computerId);
    }
    if (prop === 'amount') {
      setAmount(event.target.value);
      calculate(api + 'time/' + values.computerId + '/' + event.target.value, 'amount');
    }
  };

  const refreshStartAndEnd = (minutes, cId) => {
    let now = new Date();
    let finish = new Date();
    finish.setHours(finish.getHours(), finish.getMinutes() + minutes, 0, 0);
    setStart(convertDateToDateTimeLocal(now));
    setEnd(convertDateToDateTimeLocal(finish));
    setValues({ ...values, 'computerId': cId, 'start': convertDateToDateTimeLocal(now), 'end': convertDateToDateTimeLocal(finish) });
  }

  return (
    <div>
      <Tooltip title="New">
        <IconButton aria-label="new" onClick={handleClickOpen}>
          <AddIcon />
        </IconButton>
      </Tooltip>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Nueva Renta</DialogTitle>
        <DialogContent>
          <TextField autoFocus required select
            margin="dense" id="clientId" label="Cliente" helperText="Por favor, seleccione un cliente"
            value={values.clientId} onChange={handleChange('clientId')}
          ><MenuItem value=""><em>Seleccione</em></MenuItem>
            {clients.map(option => (
              <MenuItem key={option.id} value={option.id}>
                {option.name}
              </MenuItem>
            ))}
          </TextField>
          <TextField required select
            margin="dense" id="computerId" label="Computador" helperText="Por favor, seleccione un computador"
            value={values.computerId} onChange={handleChange('computerId')}
          ><MenuItem value=""><em>Seleccione</em></MenuItem>
            {computers.map(option => (
              <MenuItem key={option.id} value={option.id}>
                {option.name}
              </MenuItem>
            ))}
          </TextField>
          <TextField disabled={(values.computerId === '') ? true : false}
            margin="dense" id="time" label="Tiempo" type="number" value={time}
            InputProps={{ startAdornment: <InputAdornment position="start">Minutos</InputAdornment>, }}
            onChange={handleCalculate('time')}
          />
          <TextField disabled={(values.computerId === '') ? true : false}
            margin="dense" id="amount" label="Monto" type="number" value={amount}
            InputProps={{ startAdornment: <InputAdornment position="start">$</InputAdornment>, }}
            onChange={handleCalculate('amount')}
          />
          <TextField required disabled
            id="start" label="Inicio" type="datetime-local" value={start}
            onChange={handleChange('start')} InputLabelProps={{ shrink: true, }}
          />
          <TextField required disabled
            id="end" label="Fin" type="datetime-local" value={end}
            onChange={handleChange('end')} InputLabelProps={{ shrink: true, }}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancelar
          </Button>
          <Button onClick={handleSubmit} color="primary">
            Guardar
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
