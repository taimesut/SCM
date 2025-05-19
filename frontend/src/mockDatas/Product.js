
import macbook_image from '../assets/macbook_image.png';
import samsung_s23phone_image from '../assets/samsung_s23phone_image.png';
import apple_earphone_image from '../assets/apple_earphone_image.png';

export const mockProducts = [
  {
    id: 1,
    name: "MacBook Air M1",
    price: 20990000,
    category: "laptop",
    image: macbook_image,
    description: "Laptop siêu mỏng nhẹ với chip Apple M1"
  },
  {
    id: 2,
    name: "Samsung Galaxy S23",
    price: 18990000,
    category: "phone",
    image: samsung_s23phone_image,
    description: "Điện thoại flagship với camera 200MP"
  },
  {
    id: 3,
    name: "AirPods Pro 2",
    price: 5990000,
    category: "headphone",
    image: apple_earphone_image,
    description: "Tai nghe không dây chống ồn chủ động"
  }
];

export const categories = [
  { id: 'phone', name: 'Phone' },
  { id: 'laptop', name: 'Laptop' },
  { id: 'headphone', name: 'Headphone' }
];