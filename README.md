# Microserviço: payment-service

### Method: GET
* **Endpoint:** http://localhost:8080/payment-service/{idTransacao}

### Method: POST
* **Endpoint:** http://localhost:8080/payment-service/
* **Payload:** 
```json5
{
    "idTransacao": 1,
    "numeroCartao": "1234-1234-1234-1234",
    "validadeCartao": "12/2020",
    "valorCompra": 5000.00,
    "bandeira": "VISA"
}
```
* **Response:** http://localhost:8080/payment-service/{idTransacao}

### Method: PATCH
* **Endpoint:** http://localhost:8080/payment-service/{idTransacao}

* **Payload:** 
```json5
{
    "numeroCartao": "1111-2222-3333-4444",
    "validadeCartao": "04/2025",
    "valorCompra": 5000.00,
    "bandeira": "Mastercard"
}
```
* **Response:** http://localhost:8080/payment-service/{idTransacao}

### Method: DELETE
* **Endpoint:** http://localhost:8080/payment-service/{idTransacao}

