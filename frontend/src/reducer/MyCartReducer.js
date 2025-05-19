import cookie from 'react-cookies';

export default (current, action) => {
    if (action.type === 'update') {
        let cart = cookie.load('cart') || {};
        let total = 0;
        for (let c of Object.values(cart))
            total += c['quantity'];
        return total;
    } else if (action.type === 'paid') {
        cookie.remove('cart');
        return 0;
    } else if (action.type === 'remove') {
        let cart = cookie.load('cart') || {};
        if (action.payload && cart[action.payload]) {
            delete cart[action.payload];
            cookie.save('cart', cart);
        }
        let total = 0;
        for (let c of Object.values(cart))
            total += c['quantity'];
        return total;
    }

    return current;
}
