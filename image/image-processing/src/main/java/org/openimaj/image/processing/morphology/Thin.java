/**
 * Copyright (c) 2011, The University of Southampton and the individual contributors.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * 	Redistributions of source code must retain the above copyright notice,
 * 	this list of conditions and the following disclaimer.
 *
 *   *	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 *
 *   *	Neither the name of the University of Southampton nor the names of its
 * 	contributors may be used to endorse or promote products derived from this
 * 	software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.openimaj.image.processing.morphology;

import org.openimaj.image.FImage;
import org.openimaj.image.pixel.ConnectedComponent;
import org.openimaj.image.processor.ImageProcessor;
import org.openimaj.image.processor.connectedcomponent.ConnectedComponentProcessor;

/**
 * Morphological thinning of connected components and (assumed binary) FImages.
 * 
 * @author Jonathon Hare (jsh2@ecs.soton.ac.uk)
 */
public class Thin implements ConnectedComponentProcessor, ImageProcessor<FImage> {
	protected HitAndMiss hitAndMiss;
	
	/**
	 * Construct the thinning operator with the given structuring element
	 * @param se the structuring element
	 */
	public Thin(StructuringElement... se) {
		this.hitAndMiss = new HitAndMiss(se);
	}
	
	@Override
	public void process(ConnectedComponent cc) {
		hitAndMiss.process(cc);
		
		cc.getPixels().removeAll(hitAndMiss.outputPixels);
	}

	/* (non-Javadoc)
	 * @see org.openimaj.image.processor.ImageProcessor#processImage(org.openimaj.image.Image)
	 */
	@Override
	public void processImage(FImage image) {
		FImage newImage = image.process(hitAndMiss, true);
		
		for (int y=0; y<newImage.height; y++) {
			for (int x=0; x<newImage.width; x++) {
				if (newImage.pixels[y][x] == 1) {
					image.pixels[y][x] = 0;
				}
			}
		}
	}
}
