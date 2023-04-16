public class Cliente {
	public static void main(String[] args) throws Exception {

		// Método SEM Proxy
		System.out.println("\n\n\n\n\nExemplo SEM Proxy");

		// Instância o ServidorVideo
		ServidorVideo vp = new ServidorVideo();

		for (int i = 1; i <= 5; i++) {
			vp.carregarVideo(1);
		}

		// Métodos COM Proxy
		System.out.println("\n\n\n\n\nExemplo COM Proxy");

		// Instâncio o ServidorVideoProxy já com a autênticação do usuário
		ServidorVideoProxy vpProxy = new ServidorVideoProxy("VALIDO");

		for (int i = 1; i <= 5; i++) {
			vpProxy.carregarVideo(1);
		}
	}
}
