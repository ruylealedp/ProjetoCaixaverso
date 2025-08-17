public class Agendamento {
    private String nomePet;
    private String nomeDono;
    private String data;
    private String hora;
    private String servico;

    public Agendamento(String nomePet, String nomeDono, String data, String hora, String servico) {
        this.nomePet = nomePet;
        this.nomeDono = nomeDono;
        this.data = data;
        this.hora = hora;
        this.servico = servico;
    }

    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Agendamento ---");
        System.out.println("Serviço: " + servico);
        System.out.println("Nome do Pet: " + nomePet);
        System.out.println("Nome do Dono: " + nomeDono);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        System.out.println("-------------------------------\n");
    }
}