package br.com.brunobrasilweb.springadm.model;

/**
 * Enumerador que armazena os status de um pedido.
 * Atualmente contamos com quatro tipos, são eles:
 * 
 * "Enviado para cozinha"
 * "Cancelado"
 * "Na Fila"
 * "Saiu para entrega"
 * 
 * Caso futuramente os pedidos contemplem um novo "status"
 * ele deve ser adicionado abaixo.
 *
 * @author João Bonin
 * 
 * @since 28/09/2017
 */
public enum Status {

    SENT_TO_KITCHEN("Enviado para cozinha"),
    CANCELED("Cancelado"),
    IN_QUEUE("Na fila"),
    OUT_FOR_DELIVERY("Saiu para entrega");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
