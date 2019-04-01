package com.aem.nimish.core.models.components.content;

import com.aem.nimish.core.models.components.content.beans.TextBean;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;

import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;

@Model(adaptables = SlingHttpServletRequest.class)
public class Text {

private static final Logger logger = LoggerFactory.getLogger(Text.class);

@Self
private SlingHttpServletRequest request;

@ValueMapValue
@Optional
@Default(values = {"Hello World"})
private  String text;

@ValueMapValue
@Optional
@Default(values = {"H1"})
private String anchorName;

TextBean textBean = new TextBean();

@PostConstruct
public void initText(){
	textBean.setContent(text);
	textBean.setAnchorName(anchorName);

}
	public TextBean getTextBean() {
		return textBean;
	}


}
