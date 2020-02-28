import React from 'react';
import axios from 'axios';
import { Button } from '@material-ui/core';
import { Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle } from '@material-ui/core';
import { IconButton, Tooltip } from '@material-ui/core';
import DeleteIcon from '@material-ui/icons/Delete';

export default function FormDialog(props) {
  const { selected, api } = props;
  const [open, setOpen] = React.useState(false);

  async function deleteItem(url) {
    const response = await axios.delete(url);
    console.log(response);
  }

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleDelete = () => {
    handleClose();
    for (const [, item] of selected.entries()) {
      deleteItem(api + item);
    };
  };

  return (
    <div>
      <Tooltip title="Delete">
        <IconButton aria-label="delete" onClick={handleClickOpen}>
          <DeleteIcon />
        </IconButton>
      </Tooltip>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title">Eliminar Categoria(s)</DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            Esta seguro de eliminar esta(s) categoria(s)?
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancelar
          </Button>
          <Button onClick={handleDelete} color="primary">
            Aceptar
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
