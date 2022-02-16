import java.util.ArrayList;

public class Mall {
  private String nom;
  private String adresse;
  private ArrayList<Magasin> magasinsList;

  public Mall() {
    magasinsList = new ArrayList<Magasin>();
  }

  public Mall(String nom, String adresse) {
    this();

    this.nom = nom;
    this.adresse = adresse;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public ArrayList<Magasin> getMagasinsList() {
    return magasinsList;
  }

  public void setMagasinsList(ArrayList<Magasin> magasinsList) {
    this.magasinsList = magasinsList;
  }

  public void addMagasinToMall(Magasin m) {
    this.magasinsList.add(m);
  }

  public void removeMagasinToMall(Magasin m) {
    this.magasinsList.remove(m);
  }

  public void listerMagasinToMall() {
    for (Magasin magasin : magasinsList) {
      // if (magasin.getClass().getName().equals("VetementMagasin"))
      if (magasin instanceof VetementMagasin)
        magasin.infosMagasin();
    }
  }

  public float getTotalMontant() {
    float montant = 0;

    for (Magasin magasin : magasinsList) {
      montant += magasin.getMontant();
    }

    return montant;
  }

  public float getAverageMontant() {
    return getTotalMontant() / magasinsList.size();
  }

  @Override
  public String toString() {
    String res = "Mall { nom = " + nom + ", adresse = " + adresse + "\n";

    for (Magasin magasin : magasinsList) {
      res += "\t" + magasin.toString() + "\n";
    }

    return res + "}";
  }

}
