package q4.view;

import java.util.Objects;

import q4.model.Element;

/**
 * Factorises the code shared by the different ViewElement concrete classes. 
 * @author ablouin
 */
abstract class AbsViewElement implements ViewElement {
	/** The model that the view will represent. */
	protected Element model;
	
	/**
	 * @param model The model that the view will represent.
	 * @throws NullPointerException If the given model is null.
	 */
	public AbsViewElement(final Element model) {
		super();
		this.model = Objects.requireNonNull(model);
	}
	

	@Override
	public Element getModel() {
		return model;
	}
}
