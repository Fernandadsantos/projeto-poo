/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compartilhado.factoryNotificacoes;
 

/**
 *
 * @author fernanda
 */
public class factory {
    public Notificacao criarNotificacao(TipoNotificao TipoNotificao, String msg) {
		switch(TipoNotificao) {
		case EMAIL:
			return new Email(msg);
		case SMS:
			return new SMS(msg);
		case WHATSAPP:
			return new WhatsApp(msg);
		default:
			throw new IllegalArgumentException("TIPO DESCONHECIDO");
			
		}  
	}
	
	public enum TipoNotificao {
		SMS, EMAIL, WHATSAPP
	}

}
