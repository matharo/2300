public abstract class SelectableShape implements SceneShape
{
	private boolean selected;

	public boolean isSelected()
	{
		return selected;
	}
	public void setSelected(boolean b)
	{
		selected = b;
	}
}
