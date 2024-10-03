/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compartilhado.factoryNotificacoes;
 
/**
 *
 * @author fernanda
 */
public class Email implements Notificacao{
  private  String msg;
    
    public Email (String newMsg){
        this.msg = newMsg;
    }
    

    @Override
    public String enviarNotificacao() {
        return msg;
    } 
    
}
