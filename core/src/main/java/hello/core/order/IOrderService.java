package hello.core.order;

public interface IOrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
