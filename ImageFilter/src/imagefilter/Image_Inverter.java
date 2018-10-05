/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import static ij.plugin.filter.PlugInFilter.DOES_ALL;
import static ij.plugin.filter.PlugInFilter.DOES_STACKS;
import static ij.plugin.filter.PlugInFilter.SUPPORTS_MASKING;
import ij.process.ImageProcessor;
import java.awt.Rectangle;

/**
 *
 * @author gabrielle
 */
public class Image_Inverter implements PlugInFilter{
    public int setup(String arg, ImagePlus imp) {
        return DOES_ALL+DOES_STACKS+SUPPORTS_MASKING;
    }
    public void run(ImageProcessor ip) {
      Rectangle r = ip.getRoi();
      for (int y=r.y; y<(r.y+r.height); y++)
        for (int x=r.x; x<(r.x+r.width); x++)
          ip.set(x, y, ~ip.get(x,y));
    }
}
