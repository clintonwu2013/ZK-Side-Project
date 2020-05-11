package demo.layout.complex_border_layout;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.image.AImage;
import org.zkoss.sound.AAudio;
import org.zkoss.zul.Audio;
import org.zkoss.zul.Image;

public class AudioToZkImageConverter implements Converter<AAudio, byte[], Audio> {

    private Log logger = LogFactory.getLog(AudioToZkImageConverter.class);

	@Override
	public AAudio coerceToUi(byte[] beanProp, Audio component, BindContext ctx) {
		try {
            if (beanProp != null && beanProp.length > 0) {
                AAudio im = new AAudio("", beanProp);
                component.setContent(im);
                return im;
            }
            logger.debug("Return null => image is empty");
            return null;
        } catch (IOException e) {
            logger.error("Error occured, returning null", e);
            return null;
        }
	}

	@Override
	public byte[] coerceToBean(AAudio compAttr, Audio component, BindContext ctx) {
		// TODO Auto-generated method stub
		return compAttr.getByteData();
	}

    
}