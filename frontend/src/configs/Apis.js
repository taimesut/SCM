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
    'orders': '/secure/detail-receipt-export/user-receipt',
    'cancel-receipt': (id) => `/secure/receipt-export/${id}/cancel`,
    'payment-banking': '/secure/payment/payos',
    'payment-cod': '/secure/payment/cod',
    'payment-update': '/secure/payment/update-invoice'
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