
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
<<<<<<< HEAD
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // 1. Membuat objek pengelola karakter
        CharacterManager manager = new CharacterManager();

        // 2. Menambahkan data karakter
        manager.addCharacter(
            new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 4)
        );

        // 3. Mengambil rata-rata level karakter
        double averageLevel = manager.getAverageLevel();

        // 4. Menjalankan GUI pada Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                manager.getAllCharacters(),
                averageLevel
            );

            window.setVisible(true);
        });
=======
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("=== Character Manager v0.2 - CRUD Test ===");

        // =========================
        // TAMBAH KARAKTER
        // =========================

        Character arjuna = new Character(
                "Arjuna",
                CharacterType.WARRIOR,
                5
        );

        Character merlin = new Character(
                "Merlin",
                CharacterType.MAGE,
                3,
                130,
                25
        );

        Character athena = new Character(
                "Athena",
                CharacterType.WARRIOR,
                4
        );

        manager.addCharacter(arjuna);
        manager.addCharacter(merlin);
        manager.addCharacter(athena);

        // =========================
        // TEST KARAKTER DUPLIKAT
        // =========================

        Character arjunaDuplicate = new Character(
                "Arjuna",
                CharacterType.WARRIOR,
                7
        );

        manager.addCharacter(arjunaDuplicate);

        // =========================
        // JUMLAH KARAKTER
        // =========================

        System.out.println(
                "Total karakter saat ini: "
                        + manager.getTotalCharacters()
        );

        // =========================
        // FITUR ANALITIK BAGIAN C
        // countByType()
        // =========================

        System.out.println("\n--- Analitik ---");

        System.out.println(
                "Jumlah WARRIOR: "
                        + manager.countByType(CharacterType.WARRIOR)
        );

        System.out.println(
                "Jumlah MAGE: "
                        + manager.countByType(CharacterType.MAGE)
        );

        // =========================
        // PENCARIAN
        // =========================

        System.out.println("\n--- Pencarian ---");

        Character found = manager.findByName("Merlin");

        if (found != null) {
            System.out.println("Ditemukan: " + found);
        } else {
            System.out.println("Merlin tidak ditemukan");
        }

        Character notFound = manager.findByName("Zeus");

        if (notFound != null) {
            System.out.println("Ditemukan: " + notFound);
        } else {
            System.out.println("Zeus tidak ditemukan (sesuai harapan)");
        }

        // =========================
        // PENGHAPUSAN
        // =========================

        System.out.println("\n--- Penghapusan ---");

        manager.removeCharacter("Athena");

        System.out.println(
                "Total setelah hapus: "
                        + manager.getTotalCharacters()
        );

        // =========================
        // DAFTAR KARAKTER TERSISA
        // =========================

        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // =========================
        // EKSPERIMEN REFERENCE OBJECT
        // =========================

        System.out.println("\n--- Eksperimen Reference Object ---");

        Character character1 = new Character(
                "Arjuna",
                CharacterType.WARRIOR,
                5
        );

        Character character2 = character1;

        System.out.println("Sebelum perubahan:");
        System.out.println("character1: " + character1);
        System.out.println("character2: " + character2);

        character2.setName("Arjuna Baru");

        System.out.println("\nSetelah character2.setName():");
        System.out.println("character1: " + character1);
        System.out.println("character2: " + character2);

        System.out.println(
                "\nApakah character1 == character2? "
                        + (character1 == character2)
        );
>>>>>>> 02e9e829d5c26172b874c33d94745de6527ae9cd
    }
}
