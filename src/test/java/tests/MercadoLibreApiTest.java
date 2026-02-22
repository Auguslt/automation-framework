package tests;

import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercadoLibreApiTest {

    @Test
    public void testMercadoLibreDepartments() throws Exception {
        // URL del servicio de Mercado Libre
        URL url = new URL("https://www.mercadolibre.com.ar/menu/departments");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Obtener el código de respuesta
        int responseCode = connection.getResponseCode();
        Assert.assertEquals(responseCode, 200, "Error: La conexión no fue exitosa");

        // Verificar si la respuesta contiene la palabra "departments"
        String responseMessage = new String(connection.getInputStream().readAllBytes());
        Assert.assertTrue(responseMessage.contains("departments"), "La respuesta no contiene 'departments'");
    }
}