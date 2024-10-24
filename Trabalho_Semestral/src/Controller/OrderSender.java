package Controller;

import Model.CartItem;
import org.json.JSONObject;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONObject;

public class OrderSender {

    // Classe OrderItem permanece a mesma
    public static class OrderItem {

        String img;
        String name;
        float price;
        String quantity;
        String productId;

        public OrderItem(String img, String name, float price, String quantity, String productId) {
            this.img = img;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.productId = productId;
        }

        public JSONObject toJson() {
            JSONObject json = new JSONObject();
            json.put("img", img);  // Placeholder, pode ser adaptado
            json.put("name", name);
            json.put("price", price);
            json.put("quantity", quantity);
            json.put("productId", productId);
            return json;
        }

        @Override
        public String toString() {
            return "OrderItem{"
                    + "img='" + img + '\''
                    + ", name='" + name + '\''
                    + ", price=" + price
                    + ", quantity='" + quantity + '\''
                    + ", productId='" + productId + '\''
                    + '}';
        }

    }

    // Novo método para enviar os dados a partir de CartItem
    public static void sendOrder(List<CartItem> cartItems) {
        // Converter CartItem para OrderItem
        List<OrderItem> orderItems = cartItems.stream().map(cartItem
                -> new OrderItem(
                        "https://example.com/img", // placeholder, pois CartItem não tem img
                        cartItem.getNomeProduto(),
                        Float.parseFloat(cartItem.getPrecoUnit()),
                        cartItem.getQuantidade(),
                        cartItem.getIdProduto()
                )
        ).toList();
        
        // Criar JSONArray para armazenar os itens do pedido
        JSONArray jsonArray = new JSONArray();

        // Converter cada OrderItem para JSON e adicionar ao JSONArray
        for (OrderItem orderItem : orderItems) {
            jsonArray.put(orderItem.toJson());  // Chama o método toJson() do OrderItem
        }

        // Imprimir o JSONArray no formato JSON
        System.out.print(jsonArray.toString());

        // Criar JSONObject da ordem
        JSONObject data = new JSONObject();
        data.put("buttonToken", "VOID-04fce89f-0952-4736-8c35-c93c0e503809");
        data.put("orderItems", orderItems.stream().map(OrderItem::toJson).toList());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/order/createOrder"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject responseJson;
            responseJson = JsonParser.parseString(response.body()).getAsJsonObject();

            boolean status = responseJson.has("status") && responseJson.get("status").getAsBoolean();
            if (status) {
                String orderId = responseJson.has("orderId") ? responseJson.get("orderId").getAsString() : "";
                String buttonToken = responseJson.has("buttonToken") ? responseJson.get("buttonToken").getAsString() : "";
                String redirectUrl = String.format("http://localhost:3000/pay/pay?orderid=%s&buttontoken=%s", orderId, buttonToken);

                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(new URI(redirectUrl));
                    } else {
                        System.out.println("Browse action is not supported on your platform.");
                    }
                } else {
                    System.out.println("Desktop is not supported on your platform.");
                }
            } else {
                if (responseJson.has("error")) {
                    JsonArray errorArray = responseJson.getAsJsonArray("error");
                    if (errorArray.size() > 0) {
                        JsonObject error = errorArray.get(0).getAsJsonObject();
                        String errorMessage = error.has("message") ? error.get("message").getAsString() : "Unknown error";
                        System.out.println("Error: " + errorMessage);
                    }
                }
            }

        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
