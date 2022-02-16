public class VetementMagasin extends Magasin {

  private MagasinVetementSpecialite specialite;

  public VetementMagasin() {
    super();
  }

  public VetementMagasin(String nom, float superficie, float montant, MagasinVetementSpecialite specialite) {
    super(nom, superficie, montant);
    this.specialite = specialite;
  }

  public VetementMagasin(int numero, String nom, float superficie, float montant, MagasinVetementSpecialite specialite)
      throws CodeIncorrectException {
    super(numero, nom, superficie, montant);
    this.specialite = specialite;
  }

  public MagasinVetementSpecialite getSpecialite() {
    return specialite;
  }

  public void setSpecialite(MagasinVetementSpecialite specialite) {
    this.specialite = specialite;
  }

  @Override
  public String toString() {
    return "VetementMagasin { numero = " + getNumero() + ", nom = " + getNom() + ", superficie = " + getSuperficie()
        + ", montant = " + getMontant() + ", specialite = " + specialite.toString()
        + "}";
  }

}
