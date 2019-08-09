import { PlaceOrder } from './place-order';

export class Order {
    transactionStatus:string;
    buyerId: number;
    sellerId: number;
    totalPrice: number;
    placeOrders: PlaceOrder[]; 
}
