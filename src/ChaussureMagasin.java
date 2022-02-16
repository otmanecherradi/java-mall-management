public class ChaussureMagasin extends Magasin {
  private ChaussureMagasinType type;

  public ChaussureMagasin() {
    super();
  }

  public ChaussureMagasin(String nom, float superficie, float montant, ChaussureMagasinType type) {
    super(nom, superficie, montant);
    this.type = type;
  }

  public ChaussureMagasin(int numero, String nom, float superficie, float montant, ChaussureMagasinType type)
      throws CodeIncorrectException {
    super(numero, nom, superficie, montant);
    this.type = type;
  }

  public ChaussureMagasinType getType() {
    return type;
  }

  public void setType(ChaussureMagasinType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ChaussureMagasin { numero = " + getNumero() + ", nom = " + getNom() + ", superficie = " + getSuperficie()
        + ", montant = " + getMontant() + ", type = " + type.toString()
        + "}";
  }

}
