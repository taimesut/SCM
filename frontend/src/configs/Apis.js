import axios from "axios"
import cookie from 'react-cookies'

const BASE_URL = 'http://localhost:8080/SCM/api/'

export const endpoints = {
    'register': '/auth/register',
    'login': '/auth/login',
    'profile': '/secure/profile',
    'categories': '/category',
    'products': '/products/',
    'update': '/secure/update',
    'orders': '/detail-receipt-export',
    'cancel-receipt': (id) => `/receipt-export/${id}/cancel`,
    'payment': '/stripe/create-checkout-session'
}

export const authApis = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            "Authorization": `Bearer ${cookie.load('token')}`
        }
    })
}

export default axios.create({
    baseURL: BASE_URL
})