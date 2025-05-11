package br.com.fiap.quod.Service;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    public void enviarNotificacao(String tipo, String mensagem) {
        // Simulação de envio de notificação (log)
        System.out.println("[NOTIFICAÇÃO - " + tipo + "] " + mensagem);
    }

    public void notificarFraude(String detalhes) {
        enviarNotificacao("FRAUDE", "Alerta de fraude: " + detalhes);
    }

    public void notificarSucesso(String detalhes) {
        enviarNotificacao("SUCESSO", "Processo bem-sucedido: " + detalhes);
    }
}
