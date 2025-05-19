import venu_watch_image from '../assets/venu_watch_image.png'
import asus_laptop_image from '../assets/asus_laptop_image.png'
import sony_airbuds_image from '../assets/sony_airbuds_image.png'
import { tabs } from './Status';



export const orders = [
  {
    id: "ORD001",
    productName: "Laptop Asus Ultra M1",
    quantity: 2,
    category: "Laptop",
    price: 120000,
    image: asus_laptop_image,
    status: "waiting_confirm"
  },
  {
    id: "ORD002",
    productName: "Tai Nghe Sony Airbuds R4",
    quantity: 1,
    category: "Tai nghe",
    price: 250000,
    image: sony_airbuds_image,
    status: "cancelled"
  },
  {
    id: "ORD003",
    productName: "Đồng Hồ Venu Phamtom 4",
    quantity: 1,
    category: "Đồng hồ",
    price: 450000,
    image: venu_watch_image,
    status: "completed"
  },
];
