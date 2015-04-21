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
        String a1, a2, a3;
  
        assertEquals(resultadoEsperado, massa, 0);
        
        if (resultadoEsperado < 18.5){
            a1 = "Cuidado! Você está abaixo do peso";
         System.out.println(a1);
        }else if(resultadoEsperado > 18.5 && resultadoEsperado < 24.9){
            a2 = "Parabéns — você está em seu peso normal!";
        System.out.println(a2);
        }else{
             a3 = "Cuidado! Você está obeso(a)";
        System.out.println(a3);
        
        assertEquals("Cuidado! Você está obeso(a)",a3);
        }
        
        

    }
    
}
