import React from 'react';
import axios from 'axios';
import { Button, TextField, InputAdornment } from '@material-ui/core';
import { Dialog, DialogActions, DialogContent, DialogTitle } from '@material-ui/core';
import { IconButton, Tooltip } from '@material-ui/core';
import EditIcon from '@material-ui/icons/Edit';

export default function FormDialog(props) {
  const { category, api } = props;
  const [open, setOpen] = React.useState(false);
  const [values, setValues] = React.useState({
    categoryId: category.id,
    type: category.type,
    amount: category.amount,
    time: category.time
  });

  async function saveItem(url) {
    console.log(values)
    const response = await axios.post(url, values);
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
      <Tooltip title={"Edit " + category.type}>
        <IconButton aria-label="edit" onClick={handleClickOpen}>
          <EditIcon />
        </IconButton>
      </Tooltip>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Editar Categoria</DialogTitle>
        <DialogContent>
          <TextField autoFocus required fullWidth
            margin="dense" id="type" label="Tipo" type="text" defaultValue={category.type}
            onChange={handleChange('type')}
          />
          <TextField required fullWidth
            margin="dense" id="amount" label="Monto" type="number" defaultValue={category.amount}
            InputProps={{
              startAdornment: <InputAdornment position="start">$</InputAdornment>,
            }}
            onChange={handleChange('amount')}
          />
          <TextField required fullWidth
            margin="dense" id="time" label="Tiempo" type="number" defaultValue={category.time}
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
