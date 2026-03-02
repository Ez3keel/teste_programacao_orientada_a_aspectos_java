package com.testando.POA.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Diz que essa classe é um Aspecto
@Component // Torna um Bean gerenciado pelo Spring
public class TempoExecucaoAspect {


    // Define que queremos interceptar métodos do pacote service
    @Around("execution(* com.testando.POA.service.*.*(..))")
    public Object medirTempo(ProceedingJoinPoint joinPoint) throws Throwable {

        long inicio = System.currentTimeMillis();

        // Executa o metodo original
        Object resultado = joinPoint.proceed();

        long fim = System.currentTimeMillis();

        long tempoExecucao = fim - inicio;

        System.out.println("Método: " + joinPoint.getSignature().getName());
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");

        return resultado;
    }
}