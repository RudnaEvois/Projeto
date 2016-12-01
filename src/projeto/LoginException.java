/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author USER
 */
public class LoginException extends Exception {
    @Override
    public String toString(){
        return "Login ou senha Inválidos";
    }
}
