
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();
    }

    private void initComponents() {

        setTitle("Character Manager v0.3");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        mainPanel = new JPanel(new BorderLayout(10, 10));

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
            "CHARACTER MANAGER v0.3",
            SwingConstants.CENTER
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Menyiapkan kolom tabel
        String[] columns = {
            "Nama",
            "Tipe",
            "Level",
            "HP",
            "Attack Power",
            "Mana"
        };

        // Model tabel
        DefaultTableModel tableModel = new DefaultTableModel(
            columns, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Memasukkan data karakter ke tabel
        for (Character character : characterList) {

            Object[] row = {
                character.getName(),
                character.getType(),
                character.getLevel(),
                character.getHitPoints(),
                character.getAttackPower(),
                character.getMana()
            };

            tableModel.addRow(row);
        }

        JTable characterTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(characterTable);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Menampilkan rata-rata level
        JLabel averageLabel = new JLabel(
            String.format(
                "Jumlah Karakter: %d     |     Rata-rata Level: %.2f",
                characterList.size(),
                averageLevel
            )
        );

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(averageLabel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Menambahkan panel ke JFrame
        add(mainPanel);
    }
}
