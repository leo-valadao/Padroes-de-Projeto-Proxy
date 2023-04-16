public class Video {

    public Integer id;
    public String nome;
    /*
     * No caso real seria um Array de Bytes (byte[]), mas a fim de demonstração será
     * um Array
     * de String.
     */
    public String arquivoVideo;

    /*
     * Este construtor ao seu usado para instânciar um vídeo será uma simulação do
     * carregamento do vídeo do servidor para o VideoPlayer
     */
    public Video(Integer id, String nome, String arquivoVideo) throws InterruptedException {
        this.id = id;
        this.nome = nome;
        this.arquivoVideo = arquivoVideo;

        System.out.println("\nCarregandos video... Vai demorar!");

        Thread.sleep(3000);
    }

    /*
     * Este método ToString() será usado para simular a exibição do vídeo na tela do
     * cliente
     */
    @Override
    public String toString() {
        return "\nID: " + this.id + "\nNome: " + this.nome + "\nTamanho: " + this.arquivoVideo;
    }
}
