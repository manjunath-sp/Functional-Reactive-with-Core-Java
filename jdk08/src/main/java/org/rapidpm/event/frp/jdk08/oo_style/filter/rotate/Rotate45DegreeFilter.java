package org.rapidpm.event.frp.jdk08.oo_style.filter.rotate;

import com.jhlabs.image.RotateFilter;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.rapidpm.event.frp.jdk08.oo_style.filter.Filter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.jhlabs.image.TransformFilter.ZERO;

public class Rotate45DegreeFilter implements Filter {
  @Override
  public byte[] workOn(byte[] input) {

    try {
      final BufferedImage image  = Imaging.getBufferedImage(input);
      final RotateFilter   filter = new RotateFilter(45f, true);
      filter.setEdgeAction(ZERO);
      final BufferedImage resultBufferedImage = filter.filter(image, null);

      ByteArrayOutputStream os = new ByteArrayOutputStream();
      ImageIO.write(resultBufferedImage, "jpeg", os);
      byte[] result = os.toByteArray();
      return result;

    } catch (ImageReadException | IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
  }
}
