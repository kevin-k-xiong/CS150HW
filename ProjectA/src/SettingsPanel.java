import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private JButton reset;
    private JButton importExport;
    private JButton export;
    private JDialog data;

    public SettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // reset = new JButton("Reset Data");
        export = new JButton("Export Data");

        // add(reset);
        add(export);

        export.addActionListener(e -> importOrExport());

    }

    public void importOrExport() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        data = new JDialog(mainFrame, "Import/Export", Dialog.ModalityType.APPLICATION_MODAL);
        data.setLayout(new FlowLayout());
        data.getContentPane();
        importExportBtn();
        data.pack();
        data.setLocationRelativeTo(this);
        data.setVisible(true);
    }

    // Create the import/export
    public void importExportBtn() {
        reset = new JButton("Reset Data");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(reset);

        data.add(bottomPanel, BorderLayout.SOUTH);
    }

}
