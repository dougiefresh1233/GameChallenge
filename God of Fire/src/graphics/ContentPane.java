package graphics;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial") 
public class ContentPane extends JPanel {


	public ContentPane() {

		setOpaque(false);

	}

	@Override
	protected void paintComponent(Graphics g) {

		// Allow super to paint
		super.paintComponent(g);

		// Apply my own painting effect
		Graphics2D g2d = (Graphics2D) g.create();
		// 0% transparent Alpha
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0f));

		g2d.setColor(getBackground());
		g2d.fill(getBounds());

		g2d.dispose();

	}

}
