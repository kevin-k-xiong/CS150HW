import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class SettingsPanel extends JPanel {

    private JButton reset;
    private JButton confirmReset;
    private JButton cancelReset;
    private JDialog resetWindow;
    private JButton importExportBtn;
    private JButton exportBtn;
    private JButton importBtn;
    private JDialog data;

    public SettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        importExportBtn = new JButton("Import/Export");
        reset = new JButton("Reset Data");

        add(importExportBtn);
        add(reset);

        importExportBtn.addActionListener(e -> importOrExport());
        reset.addActionListener(e -> resetConfirmation());

    }

    public void importOrExport() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        data = new JDialog(mainFrame, "Import/Export", Dialog.ModalityType.APPLICATION_MODAL);
        data.setLayout(new FlowLayout());
        data.getContentPane();
        dataBtn();
        data.pack();
        data.setLocationRelativeTo(this);
        data.setVisible(true);
    }

    public void resetConfirmation() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        resetWindow = new JDialog(mainFrame, "Are You Sure?", Dialog.ModalityType.APPLICATION_MODAL);
        resetWindow.setLayout(new FlowLayout());
        resetWindow.getContentPane();
        resetChoices();
        resetWindow.pack();
        resetWindow.setLocationRelativeTo(this);
        resetWindow.setVisible(true);
    }

    public void resetChoices() {
        confirmReset = new JButton("Yes");
        cancelReset = new JButton("No");

        JPanel resetPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        resetPanel.add(confirmReset);
        resetPanel.add(cancelReset);

        resetWindow.add(resetPanel, BorderLayout.SOUTH);

    }

    // Create the import/export
    public void dataBtn() {
        importBtn = new JButton("Import Data");
        exportBtn = new JButton("Export Data");

        JPanel dataPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        dataPanel.add(importBtn);
        dataPanel.add(exportBtn);

        data.add(dataPanel, BorderLayout.SOUTH);
    }

}
