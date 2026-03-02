package com.testando.POA.aspect;

import java.util.function.Supplier;

public class TempoUtil {

    public static <T> T medir(Supplier<T> funcao) {

        long inicio = System.currentTimeMillis();
        T resultado = funcao.get();
        long fim = System.currentTimeMillis();

        System.out.println("Tempo execução: " + (fim - inicio) + " ms");

        return resultado;
    }
}