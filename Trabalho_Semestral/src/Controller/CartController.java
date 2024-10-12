package Controller;

import DAO.CartItemDAO;
import Model.CartItem;
import java.sql.SQLException;
import java.util.List;

public class CartController {

    private CartItemDAO cartItemDAO;

    public CartController() {
        this.cartItemDAO = new CartItemDAO();
    }

    public void addCartItem(CartItem cartItem) {
        cartItemDAO.save(cartItem);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemDAO.findAll();
    }

    public CartItem getCartItemById(int id) throws SQLException {
        return cartItemDAO.findById(id);
    }

    public void updateCartItem(CartItem cartItem) throws SQLException {
        cartItemDAO.update(cartItem);
    }

    public void deleteCartItem(int id) throws SQLException {
        cartItemDAO.delete(id);
    }
}
