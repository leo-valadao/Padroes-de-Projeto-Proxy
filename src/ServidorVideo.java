public class ServidorVideo implements InterfaceServidorVideo {

    @Override
    public void conectar(Integer idServidor) throws Exception {
        if (idServidor == 1) {
            throw new Exception("SERVIDOR INDISPONÍVEL!");
        } else {
            System.out.println("Conectado ao servidor " + idServidor);
        }
    }

    @Override
    public Video carregarVideo(Integer id) throws Exception {
        /*
         * Este método irá carregar o vídeo do banco de dados que
         * - Precisa estar autenticado;
         * - Pode estar remoto ou não;
         * - Pode ser exigir muito poder de processamento do servidor;
         * - Pode demorar muito tempo;
         * - Pode ter seus acessos auditados.
         */

        // Esse método seria o objeto sendo carregado do banco de dados
        Video video = new Video(Integer.valueOf(id), "VIDEO" + id, "MUITO E MUITOS BYTES");

        System.out.println("Vídeo carregado e sendo exibido na tela:\n" + video.toString());
        return video;
    }
}
