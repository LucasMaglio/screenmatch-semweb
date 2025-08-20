package br.com.alura.screenmatch.service;

public interface IConverteDados {

    //Quando nao sabermos oque vai ser devolvido usarmos o generics (<T> T)
   <T> T obterdados(String json, Class<T> classe);


}
