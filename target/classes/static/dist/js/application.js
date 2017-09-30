/* 
 * Abaixo segue o código que é disparado toda vez
 * que o usuario altera o status de um pedido individualmente.
 * 
 * @author João Bonin
 * @Date 28/09/2017
 */

$("select[name*='status']").on('change', function (event) {
    
    // obtem o ID do pedido que será alterado.
    var id = $(this).data("order-id");
    
    // Obtem o status que o pedido irá receber.
    var status = $(this).val();

    // Faz a chmada assíncrona no servidor.
    $.ajax({
        type: "GET",
        url: "/change-status/"+id,
        data: {status: status},
        success: function(data){
            console.log("Pedido alterado com sucesso.");
            // Realiza o "Refresh na página"
            location.reload();
        }
    });

});
