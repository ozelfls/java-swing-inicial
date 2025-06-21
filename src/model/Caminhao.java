package model;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String modelo, int ano, double capacidadeCarga) {
        super(placa, modelo, ano);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() { return capacidadeCarga; }
    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }

    @Override
    public void exibirDados() {
        System.out.printf("Caminhão - Modelo: %s | Placa: %s | Ano: %d | Carga: %.2f toneladas\n",
                getModelo(), getPlaca(), getAno(), capacidadeCarga);
    }
}
