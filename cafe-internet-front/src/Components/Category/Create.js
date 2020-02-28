import React from 'react';
import axios from 'axios';
import { Button, TextField, InputAdornment } from '@material-ui/core';
import { Dialog, DialogActions, DialogContent, DialogTitle } from '@material-ui/core';
import { IconButton, Tooltip } from '@material-ui/core';
import AddIcon from '@material-ui/icons/AddCircle';

export default function FormDialog(props) {
  const { api } = props;
  const [open, setOpen] = React.useState(false);
  const [values, setValues] = React.useState({
    type: '',
    amount: '',
    time: ''
  });

  async function saveItem(url) {
    const response = await axios.put(url, values);
    console.log(response);
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
  };

  const handleChange = prop => event => {
    setValues({ ...values, [prop]: event.target.value });
  };

  return (
    <div>
      <Tooltip title="New">
        <IconButton aria-label="new" onClick={handleClickOpen}>
          <AddIcon />
        </IconButton>
      </Tooltip>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Nueva Categoria</DialogTitle>
        <DialogContent>
          <TextField autoFocus required fullWidth
            margin="dense" id="type" label="Tipo" type="text"
            onChange={handleChange('type')}
          />
          <TextField required fullWidth
            margin="dense" id="amount" label="Monto" type="number"
            InputProps={{
              startAdornment: <InputAdornment position="start">$</InputAdornment>,
            }}
            onChange={handleChange('amount')}
          />
          <TextField required fullWidth
            margin="dense" id="time" label="Tiempo" type="number"
            InputProps={{
              startAdornment: <InputAdornment position="start">Minutos</InputAdornment>,
            }}
            onChange={handleChange('time')}
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
