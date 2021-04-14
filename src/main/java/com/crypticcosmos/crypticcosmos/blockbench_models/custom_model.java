// Made with Blockbench 3.8.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer Mainbody;
	private final ModelRenderer stomach;
	private final ModelRenderer stomachcube;
	private final ModelRenderer wings;
	private final ModelRenderer left_wing;
	private final ModelRenderer cube_r1;
	private final ModelRenderer right_wing;
	private final ModelRenderer cube_r2;
	private final ModelRenderer legs;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer head;
	private final ModelRenderer headcube;
	private final ModelRenderer antenna;
	private final ModelRenderer leftantenna;
	private final ModelRenderer rightantenna;
	private final ModelRenderer mouth;
	private final ModelRenderer stinksac;

	public custom_model() {
		textureWidth = 64;
		textureHeight = 64;

		Mainbody = new ModelRenderer(this);
		Mainbody.setRotationPoint(0.0F, 24.0F, -1.0F);
		

		stomach = new ModelRenderer(this);
		stomach.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mainbody.addChild(stomach);
		

		stomachcube = new ModelRenderer(this);
		stomachcube.setRotationPoint(0.0F, 0.0F, 0.0F);
		stomach.addChild(stomachcube);
		stomachcube.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, -3.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0.0F, 0.0F, 0.0F);
		stomach.addChild(wings);
		

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(0.0F, 0.0F, 0.0F);
		wings.addChild(left_wing);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_wing.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.829F);
		cube_r1.setTextureOffset(6, 23).addBox(-5.0F, -19.0F, -1.1F, 0.0F, 9.0F, 3.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(0.0F, 0.0F, 1.0F);
		wings.addChild(right_wing);
		setRotationAngle(right_wing, 0.0F, 3.1416F, 0.0873F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_wing.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.829F);
		cube_r2.setTextureOffset(0, 23).addBox(-5.0F, -19.0F, -1.1F, 0.0F, 9.0F, 3.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		stomach.addChild(legs);
		

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(rightleg);
		rightleg.setTextureOffset(2, 0).addBox(-2.0F, -5.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(4.0F, 0.0F, 0.0F);
		legs.addChild(leftleg);
		leftleg.setTextureOffset(2, 2).addBox(-2.0F, -5.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mainbody.addChild(head);
		

		headcube = new ModelRenderer(this);
		headcube.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(headcube);
		headcube.setTextureOffset(26, 10).addBox(-2.0F, -11.0F, 4.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);

		antenna = new ModelRenderer(this);
		antenna.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(antenna);
		

		leftantenna = new ModelRenderer(this);
		leftantenna.setRotationPoint(0.0F, 0.0F, 0.0F);
		antenna.addChild(leftantenna);
		leftantenna.setTextureOffset(0, 2).addBox(1.0F, -13.0F, 7.5F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		rightantenna = new ModelRenderer(this);
		rightantenna.setRotationPoint(-2.0F, 0.0F, 0.0F);
		antenna.addChild(rightantenna);
		rightantenna.setTextureOffset(0, 0).addBox(1.0F, -13.0F, 7.5F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(mouth);
		mouth.setTextureOffset(13, 15).addBox(1.0F, -8.0F, 8.0F, 0.0F, 1.0F, 11.0F, 0.0F, false);

		stinksac = new ModelRenderer(this);
		stinksac.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mainbody.addChild(stinksac);
		stinksac.setTextureOffset(0, 14).addBox(-1.5F, -10.0F, -11.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}