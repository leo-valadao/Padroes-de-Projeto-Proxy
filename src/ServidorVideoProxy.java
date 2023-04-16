public class ServidorVideoProxy implements InterfaceServidorVideo {

    // OBJETOS
    private Video videoNoCache = null;
    private ServidorVideo servidorVideo = null;

    // CONSTRUTOR PADRÃO
    public ServidorVideoProxy(String tokenAutenticacao) throws Exception {
        this.verificarAutenticacaoUsuario(tokenAutenticacao);
    }

    // INTERFACE DO SERVIDOR DE VÍDEO
    @Override
    public void conectar(Integer idServidor) throws Exception {
        if (idServidor == 1) {
            System.out.println("SERVIDOR INDISPONÍVEL!");
            System.out.println("Procurando outro servidor...");
        }

        for (int i = 1; i <= 5; i++) {
            if (i != idServidor) {
                System.out.println("Conectado ao servidor " + i);
                break;
            }
        }
    }

    @Override
    public Video carregarVideo(Integer id) throws Exception {
        Video video = this.verificarVideoDoCache(id);

        this.realizarLog(video);

        System.out.println(video.toString() + " sendo exibido na tela!");
        return video;
    }

    // MÉTODOS
    private void realizarLog(Video video) {
        // Esse método realizaria os Logs no banco de dados
        System.out.println("Logs salvos no banco de dados!");
    }

    private boolean verificarAutenticacaoUsuario(String token) throws Exception {
        // Esse método realizaria a verificação da autênticação do usuário
        if (token == "VALIDO") {
            System.out.println("Usuário Válido!");
            return true;
        } else {
            System.out.println("Usuário Inválido!");
            throw new Exception("Usuário não autênticado!");
        }
    }

    private Video verificarVideoDoCache(Integer id) throws Exception {
        // Este método verifica se o vídeo já esta carregado no Cache
        Video video = null;

        if (this.videoNoCache != null && this.videoNoCache.id == id) {
            video = videoNoCache;
        } else {
            this.conectar(1);

            if (this.servidorVideo == null) {
                this.servidorVideo = new ServidorVideo();
            }

            video = this.servidorVideo.carregarVideo(id);
            videoNoCache = video;
        }

        return video;
    }
}
