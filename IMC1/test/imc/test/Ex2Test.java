package imc.test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author V
 */
public class Ex2Test {

    @Test
    public void testCalculos() {

        double altura = 1.25;
        double peso = 60;
        double massa = peso / (altura * altura);
        double resultadoEsperado = 38.4;
  
        assertEquals(resultadoEsperado, massa, 0);
        
        if (resultadoEsperado < 18.5){
            System.out.println("Cuidado! Você está abaixo do peso");
        }else if(resultadoEsperado > 18.5 && resultadoEsperado < 24.9){
        System.out.println("Parabéns — você está em seu peso normal!");
        }else{
        System.out.println("Cuidado! Você está obeso(a)");
        }
        

    }
    
    public void limpar() {
        
    }

}
