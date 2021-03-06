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
package org.openimaj.image.annotation.evaluation.datasets;

import org.openimaj.image.FImage;
import org.openimaj.image.MBFImage;
import org.openimaj.image.annotation.evaluation.datasets.cifar.BinaryReader;
import org.openimaj.image.annotation.evaluation.datasets.cifar.FImageReader;
import org.openimaj.image.annotation.evaluation.datasets.cifar.MBFImageReader;

/**
 * Base class for CIFAR-10 and CIFAR-100, which both contain 32x32 pixel images.
 *
 * @author Jonathon Hare (jsh2@ecs.soton.ac.uk)
 */
public abstract class CIFARDataset {
	/**
	 * Image height
	 */
	public static final int HEIGHT = 32;

	/**
	 * Image width
	 */
	public static final int WIDTH = 32;

	/**
	 * Reader for getting the data as {@link MBFImage}s
	 */
	public static BinaryReader<MBFImage> MBFIMAGE_READER = new MBFImageReader(HEIGHT, WIDTH);

	/**
	 * Reader for getting the data as {@link FImage}s
	 */
	public static BinaryReader<FImage> FIMAGE_READER = new FImageReader(HEIGHT, WIDTH);
}
