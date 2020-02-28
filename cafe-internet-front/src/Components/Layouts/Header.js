import React from 'react';
import { AppBar, Toolbar, Typography, IconButton, Drawer } from '@material-ui/core';
import { List, ListItem, ListItemIcon, ListItemText, Divider } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import MenuIcon from '@material-ui/icons/Menu';
import ComputerIcon from '@material-ui/icons/Computer';
import RoomServiceIcon from '@material-ui/icons/RoomService';
import CategoryIcon from '@material-ui/icons/Category';

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
}));

function Header() {
    const classes = useStyles();
    const [state, setState] = React.useState({
        top: false,
        left: false,
        bottom: false,
        right: false,
    });
    const toggleDrawer = (side, open) => event => {
        if (event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
            return;
        }

        setState({ ...state, [side]: open });
    };

    const sideList = side => (
        <div
            className={classes.list}
            role="presentation"
            onClick={toggleDrawer(side, false)}
            onKeyDown={toggleDrawer(side, false)}
        >
            <List>
                {['Rentas'].map((text, index) => (
                    <ListItem button key={text}>
                        <ListItemIcon><RoomServiceIcon /></ListItemIcon>
                        <ListItemText primary={text} />
                    </ListItem>
                ))}
            </List>
            <Divider />
            <List>
                {['Clientes', 'Computadores', 'Categorias', 'Estatus'].map((text, index) => (
                    <ListItem button key={text}>
                        <ListItemIcon>{index === 0 ? <AccountCircleIcon /> : index === 1 ? <ComputerIcon /> : <CategoryIcon />}</ListItemIcon>
                        <ListItemText primary={text} />
                    </ListItem>
                ))}
            </List>
        </div>
    );
    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu" onClick={toggleDrawer('left', true)}>
                        <MenuIcon />
                    </IconButton>
                    <Drawer open={state.left} onClose={toggleDrawer('left', false)}>
                        {sideList('left')}
                    </Drawer>
                    <Typography variant="h6" className={classes.title}>
                        Cafe Internet Ceiba
            </Typography>
                </Toolbar>
            </AppBar>
        </div>)
}

export default Header;