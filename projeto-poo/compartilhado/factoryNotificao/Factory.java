package compartilhado.factoryNotificacao;
 

/**
 *
 * @author fernanda
 */
public class factory {
    public Notificacao criarNotificacao(TipoNotificao TipoNotificao) {
		switch(TipoNotificao) {
		case EMAIL:
			return new Email( );
		case SMS:
			return new SMS( );
		case WHATSAPP:
			return new WhatsApp( );
		default:
			throw new IllegalArgumentException("TIPO DESCONHECIDO");
			
		}  
	}
	
	public enum TipoNotificao {
		SMS, EMAIL, WHATSAPP
	}

}