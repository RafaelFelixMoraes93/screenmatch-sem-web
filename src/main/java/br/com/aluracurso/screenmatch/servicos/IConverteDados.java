package br.com.aluracurso.screenmatch.servicos;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
