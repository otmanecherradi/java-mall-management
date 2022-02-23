import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

  static Mall mall;
  static Scanner scanner;

  static MenuOptions menuOption;

  public static void main(String[] args) {

    mall = new Mall("Mall of malls", "Los Angeles, California, USA.");
    scanner = new Scanner(System.in);

    welcome();

    try {

      do {
        showMenu();

        menuOption = getOption();

        dispatchAction(menuOption);
      } while (!menuOption.equals(MenuOptions.Quit));

      goodBye();

    } catch (Exception e) {
      System.out.println("well some is wrong for sure");
    }

  }

  static void showMenu() {
    System.out.println(" -- Menu -- ");

    System.out.println("* to " + MenuOptions.Add.toString() + ", enter: '" + MenuOptions.Add.toString() + "'");
    System.out.println("* to " + MenuOptions.List.toString() + ", enter: '" + MenuOptions.List.toString() + "'");
    System.out.println("* to " + MenuOptions.Search.toString() + ", enter: '" + MenuOptions.Search.toString() + "'");
    System.out.println("* to " + MenuOptions.Update.toString() + ", enter: '" + MenuOptions.Update.toString() + "'");
    System.out.println("* to " + MenuOptions.Remove.toString() + ", enter: '" + MenuOptions.Remove.toString() + "'");

    System.out.println("* to " + MenuOptions.Quit.toString() + ", enter: '" + MenuOptions.Quit.toString() + "'");

    System.out.println(" -- choose something to begin with: ");
  }

  static void welcome() {
    System.out.println(" -- Welcome to " + mall.getNom() + " -- ");
    System.out.println(" -- adresse " + mall.getAdresse() + " -- ");
  }

  static void goodBye() {
    System.out.println(" -- Thank you for using " + mall.getNom() + " -- ");
    System.out.println(" -- Goodbye -- ");
  }

  static MenuOptions getOption() {
    String option = scanner.next();
    return MenuOptions.valueOf(option);
  }

  static void dispatchAction(MenuOptions menuOption) {
    switch (menuOption) {
      case Add:
        addMagasin();
        break;

      case List:
        listerMagasin();
        break;

      case Search:
        findMagasin();
        break;

      case Update:
        updateMagasin();
        break;

      case Remove:
        removeMagasin();
        break;

      default:
        break;
    }
  }

  static void addMagasin() {
    System.out.println("-- add magasin -- ");

    System.out.println("-- give me the name -- ");
    String nom = scanner.next() + scanner.nextLine();

    System.out.println("-- give me the superficie -- ");
    float superficie = scanner.nextFloat();

    System.out.println("-- give me the montant -- ");
    float montant = scanner.nextFloat();

    System.out.println("-- choose a type ('vetement', 'ameublement', 'chaussure') -- ");
    String magasinType = scanner.next();

    Magasin m = null;

    switch (magasinType) {
      case "vetement":
        System.out.println("-- give me the specialite -- ");
        printMagasinVetementSpecialite();

        MagasinVetementSpecialite specialite = MagasinVetementSpecialite.valueOf(scanner.next());
        m = new VetementMagasin(nom, superficie, montant, specialite);
        break;
      case "ameublement":
        System.out.println("-- give me the categorie -- ");
        printAmeublementMagasinCategorie();

        AmeublementMagasinCategorie categorie = AmeublementMagasinCategorie.valueOf(scanner.next());
        m = new AmeublementMagasin(nom, superficie, montant, categorie);
        break;
      case "chaussure":
        System.out.println("-- give me the categorie -- ");
        printChaussureMagasinType();

        ChaussureMagasinType type = ChaussureMagasinType.valueOf(scanner.next());
        m = new ChaussureMagasin(nom, superficie, montant, type);
        break;
      default:
        System.out.println("-- wrong type --");
        break;
    }

    if (m != null) {
      mall.addMagasinToMall(m);
      System.out.println("-- Magasin added successfully --");
    }
  }

  static void listerMagasin() {
    System.out.println("-- Lister Magasin -- ");
    System.out.println("-- Le Mall possede " + mall.getMagasinsList().size() + " magasins.");

    for (Magasin magasin : mall.getMagasinsList()) {
      printMagasin(magasin);
    }
  }

  static void findMagasin() {
    System.out.println("-- find magasin -- ");

    System.out.println("-- choose a criteria ('id', 'name') -- ");
    String criteria = scanner.next();

    Magasin m = null;

    switch (criteria) {
      case "id":
        System.out.println("-- give me the id -- ");
        int id = scanner.nextInt();

        m = getMagasinById(id);
        break;
      case "name":
        System.out.println("-- give me the name -- ");
        String name = scanner.next() + scanner.nextLine();

        m = getMagasinByName(name);
        break;
      default:
        System.out.println("-- wrong criteria --");
        break;
    }

    if (m != null) {
      printMagasin(m);
    }
  }

  static void updateMagasin() {
    System.out.println("-- update magasin -- ");

    System.out.println("-- find magasin first, choose a criteria ('id', 'name') -- ");
    String criteria = scanner.next();

    Magasin m = null;

    switch (criteria) {
      case "id":
        System.out.println("-- give me the id -- ");
        int id = scanner.nextInt();

        m = getMagasinById(id);
        break;
      case "name":
        System.out.println("-- give me the name -- ");
        String name = scanner.next() + scanner.nextLine();

        m = getMagasinByName(name);
        break;
      default:
        System.out.println("-- wrong criteria --");
        break;
    }

    if (m != null) {
      printMagasin(m);

      System.out.println("-- give me the name -- ");
      String nom = scanner.next() + scanner.nextLine();

      if (!m.getNom().equals(nom)) {
        m.setNom(nom);
      }

      System.out.println("-- give me the superficie -- ");
      float superficie = scanner.nextFloat();

      if (m.getSuperficie() != superficie) {
        m.setSuperficie(superficie);
      }

      System.out.println("-- give me the montant -- ");
      float montant = scanner.nextFloat();

      if (m.getMontant() != montant) {
        m.setMontant(montant);
      }

      if (m instanceof VetementMagasin) {
        System.out.println("-- give me the specialite -- ");
        printMagasinVetementSpecialite();

        MagasinVetementSpecialite specialite = MagasinVetementSpecialite.valueOf(scanner.next());
        ((VetementMagasin) m).setSpecialite(specialite);
      }

      if (m instanceof AmeublementMagasin) {
        System.out.println("-- give me the categorie -- ");
        printAmeublementMagasinCategorie();

        AmeublementMagasinCategorie categorie = AmeublementMagasinCategorie.valueOf(scanner.next());
        ((AmeublementMagasin) m).setCategorie(categorie);
      }

      if (m instanceof ChaussureMagasin) {
        System.out.println("-- give me the categorie -- ");
        printChaussureMagasinType();

        ChaussureMagasinType type = ChaussureMagasinType.valueOf(scanner.next());
        ((ChaussureMagasin) m).setType(type);
      }

      System.out.println("-- Magasin updated successfully --");
    }
  }

  static void removeMagasin() {
    System.out.println("-- remove magasin -- ");

    System.out.println("-- choose a criteria ('id', 'name') -- ");
    String criteria = scanner.next();

    Magasin m = null;

    switch (criteria) {
      case "id":
        System.out.println("-- give me the id -- ");
        int id = scanner.nextInt();

        m = getMagasinById(id);
        break;
      case "name":
        System.out.println("-- give me the name -- ");
        String name = scanner.next() + scanner.nextLine();

        m = getMagasinByName(name);
        break;
      default:
        System.out.println("-- wrong criteria --");
        break;
    }

    if (m != null) {
      mall.getMagasinsList().remove(m);

      System.out.println("-- Magasin removed successfully --");
    }
  }

  static Magasin getMagasinById(int id) {
    ArrayList lst = (ArrayList) mall.getMagasinsList().stream().filter(m -> m.getNumero() == id)
        .collect(Collectors.toList());
    return lst.size() > 0 ? (Magasin) lst.get(0) : null;
  }

  static Magasin getMagasinByName(String name) {
    ArrayList lst = (ArrayList) mall.getMagasinsList().stream().filter(m -> m.getNom().equals(name))
        .collect(Collectors.toList());
    return lst.size() > 0 ? (Magasin) lst.get(0) : null;
  }

  static void printMagasin(Magasin magasin) {
    System.out.println("-- Magasin --");
    System.out.println(" - Numero : " + magasin.getNumero());
    System.out.println(" - Name : " + magasin.getNom());
    System.out.println(" - Superficie : " + magasin.getSuperficie() + "m^2");
    System.out.println(" - Montant : " + magasin.getMontant() + " DH");
  }

  static void printEnum(Enum e) {
    System.out.println("* to " + e.toString() + ", enter: '" + e.toString() + "'");
  }

  static void printMagasinVetementSpecialite() {
    printEnum(MagasinVetementSpecialite.Homme);
    printEnum(MagasinVetementSpecialite.Femme);
    printEnum(MagasinVetementSpecialite.Enfant);
  }

  static void printAmeublementMagasinCategorie() {
    printEnum(AmeublementMagasinCategorie.Electromenager);
    printEnum(AmeublementMagasinCategorie.Literie);
    printEnum(AmeublementMagasinCategorie.Decoration);
  }

  static void printChaussureMagasinType() {
    printEnum(ChaussureMagasinType.Sport);
    printEnum(ChaussureMagasinType.Ville);
  }
}
