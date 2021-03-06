package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Sponsorship;

@Component
@Transactional
public class SponsorshipToStringConverter implements Converter<Sponsorship, String> {

	@Override
	public String convert(Sponsorship sponsorship) {
		String res;
		if (sponsorship == null) {
			res = null;
		} else {
			res = String.valueOf(sponsorship.getId());
		}
		return res;
	}

}