import { useContext } from 'react';
import cookie from 'react-cookies'
import { MyCartContext } from '../context/MyCartContext';


const MyUserReducer = (current, action) => {
    switch (action.type) {
        case "login":
            return action.payload;
        case "logout":
            cookie.remove("token");
            cookie.remove('cart')
            return null;
    }
}

export default MyUserReducer;